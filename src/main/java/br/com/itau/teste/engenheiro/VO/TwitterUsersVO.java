package br.com.itau.teste.engenheiro.VO;

public class TwitterUsersVO {

    private String userName;
    private Double followers;

    public TwitterUsersVO(String userName, Double followers) {
        this.userName = userName;
        this.followers = followers;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getFollowers() {
        return followers;
    }

    public void setFollowers(Double followers) {
        this.followers = followers;
    }
}
