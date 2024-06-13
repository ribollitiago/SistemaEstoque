package study.tiago.sistemaestoque.jdbc;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class ConnectionTest {
    public static void main(String[] args) {
        try {
            new ConnectionDB().pullConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso ao banco de dados");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar ao banco de dados" + e.getMessage());
        }
    }
}
