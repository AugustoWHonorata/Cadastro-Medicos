public class Medico {
    private String nome;
    private String crm;
    private Integer idade;
    private String telefone;
    private String especialidade;

    // Construtor
    public Medico(String nome, String crm, Integer idade, String telefone, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.idade = idade;
        this.telefone = telefone;
        this.especialidade = especialidade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String toString() {
        return "Medico [Nome=" + nome + ", CRM=" + crm + ", Idade=" + idade +
                ", Telefone=" + telefone + ", Especialidade=" + especialidade + "]";
    }
}
