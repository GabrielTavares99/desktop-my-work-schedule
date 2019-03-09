import myworktime.view.MainView;

public class TesteApp {

    public static void main(String[] args) {

        MarcacaoManager marcacaoManager = MarcacaoManager.getInstance();

        MainView mainView = new MainView();

//        int opcao = 1;
//        while (opcao != 99) {
//            Scanner scanner = new Scanner(System.in);
//            opcao = scanner.nextInt();
//            marcacaoManager.fazerMarcacao();
//        }
//        MarcacaoRepository marcacaoRepository = new MarcacaoRepository();
//        List<Marcacao> todas = marcacaoRepository.todas();
//        marcacaoManager.setMarcacoes(todas);
//        long minutosTrabalhados = marcacaoManager.calcularTempoPorDia(LocalDate.of(2019, Month.MARCH, 5));
//        System.out.println(marcacaoManager.formataMinutosTrabalhadosEmHoras(minutosTrabalhados));
    }
}
