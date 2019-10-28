package brunofontana;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.LinguisticTerm.*;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.rule.Rule;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class BrunoFontana {

    public static void main(String[] args) {

        //Habilita o scanner
        Scanner ler = new Scanner(System.in);

        //Carrega arquivos de regras
        String file = "C:\\Users\\bruno\\Documents\\NetBeansProjects\\BrunoFontana\\src\\brunofontana\\brunofontana.fcl";

        FIS fis = FIS.load(file, true);

        //Trata erro de arquivos
        if (fis == null) {
            System.err.println("Não foi possivel carregar o arquivo: '" + file + "'");
            System.exit(1);
        }

        //Configura as entradas
        System.out.println("Aluno: Bruno Fontana R.A. -> 11716517");
        System.out.println("Qual experiência do funcionário? (0-30) anos...:  ");

        double experiencia = ler.nextDouble();
        System.out.println("");

        System.out.println("Qual o tempo de capacitação do funcionário? (0-15) anos...: ");

        double capacitacao = ler.nextDouble();
        System.out.println("");

        //Cria o function block padrão
        FunctionBlock fb = fis.getFunctionBlock(null);
        fb.setVariable("experiencia", experiencia);
        fb.setVariable("capacitacao", capacitacao);

        //Avalia Fuzzy
        fb.evaluate();

        //Imprime Resultados
        System.out.printf("O valor da gratificação sera de: R$ %9.2f \n", fb.getVariable("gratificacao").getValue());

        //Exibe regras e o grau de suporte conforme variaveis
        System.out.printf("\n \n Apresentação das regras compátiveis \n ");
        for (Rule r : fis.getFunctionBlock("gratificacoes").getFuzzyRuleBlock("No1").getRules()) {
            System.out.println(r);
        }

    }

}
