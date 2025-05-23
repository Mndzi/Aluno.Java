import java.time.LocalDate;

public class Professor extends Aluno {
    private String area;

    public Professor(String nome, LocalDate nascimento, String curso, String area) {
        super(nome, nascimento, curso);
        this.area = area;
    }

    @Override
    public String saudacao() {
        return "Olá professor " + nome + ", parabéns pela ótima aula na área de " + area + "!";
    }

    public void exibirInfoProfessor() {
        System.out.println("Nome do professor: " + nome);
        System.out.println("Área de atuação: " + area);
        System.out.println("Curso: " + curso);
    }
}
