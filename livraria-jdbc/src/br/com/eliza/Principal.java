package br.com.eliza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Principal {

	// Dados do Banco
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/livraria";
	static final String USER = "root";
	static final String PASS = "01061966";
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		executarQueries();
	}

	private static void executarQueries() {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();

			int opcao = 0;
			while (opcao != 5) {
				System.out.println("Selecione uma opção");
				System.out.println("1-Inclusão");
				System.out.println("2-Alterção");
				System.out.println("3-Exclusão");
				System.out.println("4-Consulta");
				System.out.println("5-Exit");
				opcao = scanner.nextInt();
				scanner.nextLine(); //explicação do problema de não ter essa linha: https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
				//opcao = Integer.parseInt(scanner.nextLine());
				switch (opcao) {
				case 1:
					inclusao(conn);
					break;
				case 2:
					System.out.println("alteracao");
					//alteracao(conn);
					break;
				case 3:
					System.out.println("exclusao");
					//exclusao(conn);
					break;
				case 4:
					System.out.println("consulta");
					consulta(stmt);
					break;
				case 5:
					break;
				}
			}
			scanner.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException e) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fim!");
	}

	public static void inclusao(Connection conn) throws SQLException {
		System.out.println("insert...\n");
		String sql = "INSERT INTO livrosn(titulo,autor,genero,editora,edicao,qtde_estoque,qtde_reserva,capa,data_prim_publicacao,data_cadastro,data_alteracao) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		String titulo = "";
		String autor = "";
		String genero = "";
		String editora = "";
		int edicao = 0;
		int qtde_estoque = 0;
		int qtde_reserva = 0;
		String capa ="";
		String data_prim_publicacao = "";
		String data_cadastro = "";
		String data_alteracao = "";
		System.out.println("Digite Titulo..:");
		titulo = scanner.nextLine();
		System.out.println("Digite Autor...:");
		autor = scanner.nextLine();
		System.out.println("Digite Genero..:");
		genero = scanner.nextLine();
		System.out.println("Digite Editora.:");
		editora = scanner.nextLine();
		System.out.println("Digite edição..:");
		edicao = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Qtde em estoque:");
		qtde_estoque = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Qtde de reserva:");
		qtde_reserva = scanner.nextInt();
		scanner.nextLine();
		System.out.println("insira capa....:");
		capa = scanner.nextLine();
		System.out.println("Dt.1a publicac.:");
		data_prim_publicacao = scanner.nextLine();
		System.out.println("Dt.cadastto....:");
		data_cadastro =scanner.nextLine();
		System.out.println("Dt.altercao....:");
		data_alteracao = scanner.nextLine();
		ps.setString(1, titulo);
		ps.setString(2, autor);
		ps.setString(3, genero);
		ps.setString(4, editora);
		ps.setInt(5, edicao);
		ps.setInt(6, qtde_estoque);
		ps.setInt(7, qtde_reserva);
		ps.setString(8, capa);
		ps.setString(9, data_prim_publicacao);
		ps.setString(10, data_cadastro);
		ps.setString(11, data_alteracao);
		ps.executeUpdate();
	}
	public static void consulta(Statement stmt) throws SQLException {
		String sql = "SELECT * from livrosn;\n";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println("Título: " + rs.getString("titulo"));
			System.out.println("Autor: " + rs.getString("autor"));
			System.out.println("Genero: " + rs.getString("genero"));
			System.out.println("Editora: " + rs.getString("editora"));
			System.out.println("Edicao: " + rs.getInt("edicao"));
			System.out.println("Qtde Estoque: " + rs.getInt("qtde_estoque"));
			System.out.println("Qtde Reserva: " + rs.getInt("qtde_reserva"));
			System.out.println("Capa: " + rs.getString("capa"));
			System.out.println("Dt.Prim.Public: " + rs.getString("data_prim_publicacao"));
			System.out.println("Dt.Cadastro: " + rs.getString("data_cadastro"));
			System.out.println("Dt.Alteracao: " + rs.getString("data_alteracao"));
		System.out.println();
		}
		System.out.println("#################################");
	}
}


