package br.com.itau.teste.engenheiro.VO;

public class TwitterPostsByLangVO {

    private final String total;
    private final String tagName;

    public TwitterPostsByLangVO(String total, String tagName) {
        this.total = total;
        this.tagName = tagName;
    }

    public String getTotal() {
        return total;
    }

    public String getTagName() {
        return tagName;
    }
}
