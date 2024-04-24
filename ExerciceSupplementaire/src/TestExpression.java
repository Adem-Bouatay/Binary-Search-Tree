import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

 class TestExpression {
    //  pour initialiser delimiteurs avec les paires:(clé = délimiteur ouvrant, valeur = délimiteur fermant)
    private static final Map<Character, Character> delimiteurs = new HashMap<>() {
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    public static int testEquilibre(String expression) {
        Stack<Character> stack = new Stack<>();  // pour initialiser une pile vide

        for (int i = 0; i < expression.length(); i++) { // parcour de l expression
            char c = expression.charAt(i);      // c <= expression[i]

            // Si c'est un délimiteur ouvrant, le mettre sur la pile
            if (delimiteurs.containsKey(c)) {
                stack.push(c);
            } else if (delimiteurs.containsValue(c)) {
                // Si c'est un délimiteur fermant, vérifier la pile
                if (stack.isEmpty() || !(c==(delimiteurs.get(stack.pop())))) {
                    return i + 1; // Déséquilibré, retourne la position de l'erreur
                }
            }
        }

        // Si la pile n'est pas vide, il y a des délimiteurs non fermés par exemple tout l expression est formée par des delimiteurs ouvrants
        return stack.isEmpty() ? -1 : expression.length(); // Retourne -1 si équilibré
    }
    public static void main(String[] args) {
        String expression1 = "{[()]()}";
        String expression2 = "{[)(]}";
        System.out.println("Expression 1: " + expression1);
        System.out.println("Expression 2: " + expression2);
        int result1 = testEquilibre(expression1);
        if (result1 == -1) {
            System.out.println("L'expression 1 est équilibrée.");
        } else {
            System.out.println("L'expression 1 n'est pas équilibrée. Position du premier délimiteur incorrect : " + result1);
        }
        int result2 = testEquilibre(expression2);
        if (result2 == -1) {
            System.out.println("L'expression 2 est équilibrée.");
        } else {
            System.out.println("L'expression 2 n'est pas équilibrée. Position du premier délimiteur incorrect : " + result2);
        }
    }
    }
