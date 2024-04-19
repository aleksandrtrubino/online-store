import React, { useState } from 'react'
import { useForm } from "react-hook-form";
import { baseApi } from '../../shared/api/baseApi';
import { useDispatch } from 'react-redux';

export const createProductApi = baseApi.injectEndpoints({
    endpoints: (builder) => ({
      createProduct: builder.mutation({
        query: (product) => ({
          url: "/products/images/1051",
          method: "POST",
          body: { ...product },
          withCredentials: true,
          prepareHeaders: (headers) => {
            headers.set("Content-Type", "multipart/form-data")
              return headers
          },
        }),
      }),
    }),
  });

export const {useCreateProductMutation} = createProductApi  

export const CreateProductImage = () => {

    const { register, handleSubmit } = useForm();
    const dispatch = useDispatch()
    const [createProduct] = useCreateProductMutation();
    const [imageByte, setImageByte] = useState([]);



    const uploadFiles = async (files) => {
      const formData = new FormData();
      for (let i = 0; i < files.length; i++) {
        formData.append(`file${i}`, files[i])
      }
      return formData;
    }



    const onSubmit = async (data) => {
      // console.log(data)
        //const formData = uploadFiles(data.file)
        const formData = new FormData();
         for (let i = 0; i < data.file.length; i++) {
          formData.append(`file`, data.file[i])
        }

        //const response = await createProduct(formData).unwrap();

        try{
          const result = await fetch("http://localhost:8080/api/v1/products/images/1051", {
            method: "POST",
            body: formData,
              // headers: {
              //     "Content-Type": "multipart/form-data",
              //     // "Content-Length":"<calculated when request is sent>"
              //   },
          })
          console.log(result)
        }
        catch(error){
          console.log(error)
        }
       

        const res = await fetch("http://localhost:8080/api/v1/products/images/1051", {
            method: "GET",
          })
          const d = await res.json();
          console.log(d)
          setImageByte([...d])
        for (let i =0; i < d.length; i++)  {
          // const imageBlob = await d[i].blob();
          // const imageUrl = URL.createObjectURL(imageBlob);
         // setImageByte([...imageByte, d[i]]);
        } 
        
      };
    
      return (
        <div className="createProductImage">
          <form onSubmit={handleSubmit(onSubmit)}>
            <input type="file" multiple {...register("file")} />
    
            <input type="submit" />
          </form>
          {
           imageByte.map((image) => <img style={{width:100, height:100}} src={`data:image/jpeg;base64,${image}`} alt="sfds" />)

          }
        </div>
      );
}
