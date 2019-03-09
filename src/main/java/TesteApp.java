import managers.MarkManager;
import view.MainView;

public class TesteApp {

    public static void main(String[] args) {

        MarkManager markManager = MarkManager.getInstance();

        MainView mainView = new MainView();

//        int opcao = 1;
//        while (opcao != 99) {
//            Scanner scanner = new Scanner(System.in);
//            opcao = scanner.nextInt();
//            markManager.fazerMarcacao();
//        }
//        MarkRepository marcacaoRepository = new MarkRepository();
//        List<Mark> todas = marcacaoRepository.todas();
//        markManager.setMarcacoes(todas);
//        long minutosTrabalhados = markManager.calcularTempoPorDia(LocalDate.of(2019, Month.MARCH, 5));
//        System.out.println(markManager.formataMinutosTrabalhadosEmHoras(minutosTrabalhados));
    }
}
