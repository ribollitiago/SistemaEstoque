/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package study.tiago.sistemaestoque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import study.tiago.sistemaestoque.jdbc.ConnectionDB;
import study.tiago.sistemaestoque.model.Clients;
import study.tiago.sistemaestoque.model.Employee;

/**
 *
 * @author ribol
 */
public class EmployeeDAO {
    private Connection conn;
    
    public EmployeeDAO(){
        this.conn = new ConnectionDB().pullConnection();
    }
    
    public void Salvar(Employee obj){
        try {
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getSenha());
            stmt.setString(6,obj.getCargo());
            stmt.setString(7,obj.getNivelAcesso());
            stmt.setString(8,obj.getTelefone());
            stmt.setString(9,obj.getCelular());
            stmt.setString(10,obj.getCep());
            stmt.setString(11,obj.getEndereco());
            stmt.setInt(12,obj.getNumero());
            stmt.setString(13,obj.getComplemento());
            stmt.setString(14,obj.getBairro());
            stmt.setString(15,obj.getCidade());
            stmt.setString(16,obj.getEstado());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o Funcionário: " + e);
        }
    }
    
    public void Editar(Employee obj){
        try {
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?, senha=?, cargo=?, nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getSenha());
            stmt.setString(6,obj.getCargo());
            stmt.setString(7,obj.getNivelAcesso());
            stmt.setString(8,obj.getTelefone());
            stmt.setString(9,obj.getCelular());
            stmt.setString(10,obj.getCep());
            stmt.setString(11,obj.getEndereco());
            stmt.setInt(12,obj.getNumero());
            stmt.setString(13,obj.getComplemento());
            stmt.setString(14,obj.getBairro());
            stmt.setString(15,obj.getCidade());
            stmt.setString(16,obj.getEstado());
            stmt.setInt(17,obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao editar o funcionário: " + e);
        }
    }
    
    public void Excluir(Employee obj){
        try {
            String sql = "delete from tb_funcionarios where id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,obj.getId());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o funcionário: " + e);
        }
    }
    
    public Employee SearchEmployee(String nome){
        try {
            String sql = "select * from tb_funcionarios where nome =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Employee obj = new Employee();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar funcionário: "+ e);
        }
        return null;
    }
    
    public List<Employee> CreateList(){
        List<Employee> list = new ArrayList<>();
        
        try {
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Employee obj = new Employee();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivelAcesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                list.add(obj);
            }
            return list;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao  criar a lista " + e);
        }
        return null;
    }
    
    public List<Clients> FilterList(String nome){
        List<Clients> list = new ArrayList<>();
        
        try {
            String sql = "select * from tb_clientes where nome like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clients obj = new Clients();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                list.add(obj);
            }
            return list;
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao  criar a lista " + e);
        }
        return null;
    }
}
