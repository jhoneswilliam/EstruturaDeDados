package dados;

public class Clientes {
	private int codigo;
	private String nome;
	private String cpf;
	private String telefone;
	private char sexo;
	private String dtNascimento;
	
	public Clientes(int codigo, String nome, String cpf, String telefone,
			char sexo, String dtNascimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dtNascimento = dtNascimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@Override
	public String toString() {
		return "Clientes [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf
				+ ", telefone=" + telefone + ", sexo=" + sexo
				+ ", dtNascimento=" + dtNascimento + "]";
	}

}
