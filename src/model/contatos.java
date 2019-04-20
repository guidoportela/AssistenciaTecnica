package model;

public class contatos {

    private String Nome;
    private String Email;
    private String Assunto;
    private String Mensagem;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String assunto) {
        this.Assunto = assunto;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        this.Mensagem = mensagem;
    }
}
