package ru.vistar.kionmarket.review;

public class ReviewDto {

    private Integer rating;
    private String content;
    private Long userId;
    private Long productId;

    public ReviewDto(){}

    public ReviewDto(Integer rating, String content, Long userId, Long productId) {
        this.rating = rating;
        this.content = content;
        this.userId = userId;
        this.productId = productId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
