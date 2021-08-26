package br.com.eliza.escola.principal;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.persistence.EntityManager;

import br.com.eliza.escola.dao.AlunoDao;
import br.com.eliza.escola.dao.MateriaDao;
import br.com.eliza.escola.dao.NotaDao;
import br.com.eliza.escola.dao.SerieDao;
import br.com.eliza.escola.modelo.Aluno;
import br.com.eliza.escola.modelo.Materia;
import br.com.eliza.escola.modelo.Nota;
import br.com.eliza.escola.modelo.NotaPK;
import br.com.eliza.escola.modelo.Serie;
import br.com.eliza.escola.util.DateUtil;
import br.com.eliza.escola.util.JPAUtil;

public class Principal {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		executarMenu();
	}

	private static void executarMenu() {

		int opcao = 0;
		opcoes: while (true) {
			System.out.println("Selecione uma op��o");
			System.out.println("1-Aluno");
			System.out.println("2-Materia");
			System.out.println("3-Serie");
			System.out.println("4-Nota");
			System.out.println("5-Consulta Nota por Aluno");
			System.out.println("6-Consulta Nota por Serie");
			System.out.println("7-Exit");
			opcao = scanner.nextInt();
			scanner.nextLine(); // explica��o do problema de n�o ter essa linha:
								// https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
			// opcao = Integer.parseInt(scanner.nextLine());
			switch (opcao) {
			case 1:
				System.out.println("Aluno");
				cadAluno();
				break;
			case 2:
				System.out.println("Materia");
				cadMateria();
				break;
			case 3:
				System.out.println("Serie");
				cadSerie();
				break;
			case 4:
				System.out.println("Nota");
				cadNota();
				break;
			case 5:
				System.out.println("Consulta da Nota por Aluno");
				consNotaPorAluno();
				break;
			case 6:
				System.out.println("Consulta da Nota por Serie");
				break;
			case 7:
				break opcoes;
			}
		}
		scanner.close();
	}

	private static void cadAluno() {
		EntityManager em = JPAUtil.getEntityManager();
		Long id;
		String nome;
		String sobrenome;
		LocalDate dataNascto = null;
		String data_dma;
		int ano_dma = 0;
		int mes_dma = 0;
		int dia_dma = 0;
		String cpf;
		String serieAtual;
		System.out.println("I.D........:");
		id = scanner.nextLong();
		String resp;
		AlunoDao alunoDao = new AlunoDao(em);
		Aluno aluno = alunoDao.buscarPorId(id);
		if (id > 0) {
			if (aluno.getNome() != " ") {
				System.out.println("Nome.......:" + aluno.getNome());
				System.out.println("Sobrenome..:" + aluno.getSobrenome());
				System.out.println("Data Nascto:" + aluno.getDataNascto());
				System.out.println("C.P.F......:" + aluno.getCpf());
				System.out.println("Serie Atual:" + aluno.getSerieAtual());
				System.out.println("<A>ltera��o  <E>xclus�o:");
				resp = scanner.next();
				System.out.println(resp);
				if (resp.equals("A")) {
					System.out.println("Nome.......:");
					scanner.nextLine();
					nome = scanner.nextLine();
					System.out.println("Sobrenome..:");
					sobrenome = scanner.nextLine();
					System.out.println("Data Nascto:");
					/*while (dataNascto == null) {
						data_dma = scanner.nextLine();
						ano_dma = Integer.parseInt(data_dma.substring(4));
						mes_dma = Integer.parseInt(data_dma.substring(2, 4));
						dia_dma = Integer.parseInt(data_dma.substring(0, 2));
						if (ano_dma > 0 && (mes_dma > 0 && mes_dma < 13) && (dia_dma > 0 && dia_dma < 32)) {
							if (mes_dma == 2 && dia_dma < 29) {
								dataNascto = LocalDate.of(Integer.parseInt(data_dma.substring(4)),
										Month.of(Integer.parseInt(data_dma.substring(2, 4))),
										Integer.parseInt(data_dma.substring(0, 2)));
							} else if (dia_dma <= 31 && (mes_dma == 1 || mes_dma == 3 || mes_dma == 5 || mes_dma == 7
									|| mes_dma == 8 || mes_dma == 10 || mes_dma == 12)) {
								dataNascto = LocalDate.of(Integer.parseInt(data_dma.substring(4)),
										Month.of(Integer.parseInt(data_dma.substring(2, 4))),
										Integer.parseInt(data_dma.substring(0, 2)));
							} else if (dia_dma <= 30 && (mes_dma == 4 || mes_dma == 6 || mes_dma == 9 || mes_dma == 11)) {
								dataNascto = LocalDate.of(Integer.parseInt(data_dma.substring(4)),
										Month.of(Integer.parseInt(data_dma.substring(2, 4))),
										Integer.parseInt(data_dma.substring(0, 2)));
							}
						}
					}*/
					while(true) {
						data_dma = scanner.nextLine();
						ano_dma = Integer.parseInt(data_dma.substring(4));
						mes_dma = Integer.parseInt(data_dma.substring(2, 4));
						dia_dma = Integer.parseInt(data_dma.substring(0, 2));
						DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("uuuu-MM-dd", Locale.getDefault())
				    		    .withResolverStyle(ResolverStyle.STRICT);
				    	if(DateUtil.isValid(ano_dma + "-" + mes_dma + "-" + dia_dma, dateFormatter)) {
				    		dataNascto = LocalDate.of(ano_dma, Month.of(mes_dma), dia_dma);
				    		break;
				    	}
					}
					// dataNascto = LocalDate.now();
					System.out.println(dataNascto);
					System.out.println("C.P.F......:");
					cpf = scanner.nextLine();
					System.out.println("Serie Atual:");
					serieAtual = scanner.nextLine();
					Aluno alunoA = new Aluno(nome, sobrenome, dataNascto, cpf, serieAtual);
					AlunoDao alunoDaoA = new AlunoDao(em);
					resp = " ";
					System.out.println("Confirma a Altera��o?:");
					resp = scanner.next();
					scanner.nextLine();
					if (resp.equals("S") || resp.equals("s")) {
						em.getTransaction().begin();
						alunoDaoA.atualizar(alunoA);
						em.getTransaction().commit();
						System.out.println("Aluno Alterado ");
					}
				} else if (resp.equals("E")) {
					resp = " ";
					System.out.println("Confirma a Exclusao de.:" + aluno.getNome());
					resp = scanner.next();
					if (resp.equals("S") || resp.equals("s")) {
						em.getTransaction().begin();
						alunoDao.remover(aluno);
						em.getTransaction().commit();
						System.out.println("Aluno Removido ");
					}
				}

			}

		} else {
			System.out.println("Nome.......:");
			scanner.nextLine();
			nome = scanner.nextLine();
			System.out.println("Sobrenome..:");
			sobrenome = scanner.nextLine();
			System.out.println("Data Nascto:");
			while (dataNascto == null) {
				data_dma = scanner.nextLine();
				ano_dma = Integer.parseInt(data_dma.substring(4));
				mes_dma = Integer.parseInt(data_dma.substring(2, 4));
				dia_dma = Integer.parseInt(data_dma.substring(0, 2));
				if (ano_dma > 0 && (mes_dma > 0 && mes_dma < 13) && (dia_dma > 0 && dia_dma < 32)) {
					if (mes_dma == 2 && dia_dma < 29) {
						dataNascto = LocalDate.of(Integer.parseInt(data_dma.substring(4)),
								Month.of(Integer.parseInt(data_dma.substring(2, 4))),
								Integer.parseInt(data_dma.substring(0, 2)));
					} else if (dia_dma <= 31 && (mes_dma == 1 || mes_dma == 3 || mes_dma == 5 || mes_dma == 7
							|| mes_dma == 8 || mes_dma == 10 || mes_dma == 12)) {
						dataNascto = LocalDate.of(Integer.parseInt(data_dma.substring(4)),
								Month.of(Integer.parseInt(data_dma.substring(2, 4))),
								Integer.parseInt(data_dma.substring(0, 2)));
					} else if (dia_dma <= 30 && (mes_dma == 4 || mes_dma == 6 || mes_dma == 9 || mes_dma == 11)) {
						dataNascto = LocalDate.of(Integer.parseInt(data_dma.substring(4)),
								Month.of(Integer.parseInt(data_dma.substring(2, 4))),
								Integer.parseInt(data_dma.substring(0, 2)));
					}
				}
			}
			// dataNascto = LocalDate.now();
			System.out.println(dataNascto);
			System.out.println("C.P.F......:");
			cpf = scanner.nextLine();
			System.out.println("Serie Atual:");
			serieAtual = scanner.nextLine();
			Aluno alunoI = new Aluno(nome, sobrenome, dataNascto, cpf, serieAtual);
			AlunoDao alunoDaoI = new AlunoDao(em);
			resp = " ";
			System.out.println("Confirma a Inclus�o?:");
			resp = scanner.nextLine();
			scanner.nextLine();
			if (resp.equals("S") || resp.equals("s")) {
				em.getTransaction().begin();
				alunoDaoI.cadastrar(alunoI);
				em.getTransaction().commit();
			System.out.println("Aluno Gravado" + aluno.getNome());
			}
		em.close();
		}
	}

	private static void cadMateria() {
		EntityManager em = JPAUtil.getEntityManager();
		Long id;
		String nome_Materia;
		System.out.println("I.D........:");
		id = scanner.nextLong();
		scanner.nextLine();
		if (id > 0) {
			MateriaDao materiaDao = new MateriaDao(em);
			Materia materia = materiaDao.buscarPorId(id);
			if (materia.getNome_Materia() != " ") {
				String resp;
				System.out.println("Confirma a exclusao da " + materia.getNome_Materia());
				resp = scanner.nextLine();
				System.out.println(resp);
				if (resp.equals("S") || resp.equals("s")) {
					em.getTransaction().begin();
					materiaDao.remover(materia);
					em.getTransaction().commit();
					System.out.println("Materia Removido ");
				}
			}

		} else {
			System.out.println("Nome da Materia:");
			nome_Materia = scanner.nextLine();
			Materia materia = new Materia(nome_Materia);
			MateriaDao materiaDao = new MateriaDao(em);

			em.getTransaction().begin();

			materiaDao.cadastrar(materia);

			em.getTransaction().commit();

			System.out.println("Materia Gravado " + materia.getNome_Materia());
			materiaDao.buscarTodasMaterias();

		}
		em.close();
	}

	private static void cadSerie() {
		EntityManager em = JPAUtil.getEntityManager();
		Long id;
		String nome_Serie;
		System.out.println("I.D........:");
		id = scanner.nextLong();
		scanner.nextLine();
		if (id > 0) {
			SerieDao serieDao = new SerieDao(em);
			Serie serie = serieDao.buscarPorId(id);
			if (serie.getNome_Serie() != " ") {
				String resp;
				System.out.println("Confirma a exclusao da " + serie.getNome_Serie());
				resp = scanner.nextLine();
				if (resp.equals("S") || resp.equals("s")) {
					em.getTransaction().begin();
					serieDao.remover(serie);
					em.getTransaction().commit();
					System.out.println("Serie Removido ");
				}
			}
		} else {
			System.out.println("Nome da Serie:");
			nome_Serie = scanner.nextLine();
			Serie serie = new Serie(nome_Serie);
			SerieDao serieDao = new SerieDao(em);

			em.getTransaction().begin();

			serieDao.cadastrar(serie);

			em.getTransaction().commit();

			System.out.println("Serie Gravado " + serie.getNome_Serie());
			serieDao.buscarTodasSeries();
		}
		em.close();
	}

	private static void cadNota() {
		EntityManager em = JPAUtil.getEntityManager();
		Long id;
		Long id_aluno;
		Long id_serie;
		Long id_materia;
		Float nota1Bimestre;
		Float nota2Bimestre;
		Float nota3Bimestre;
		Float nota4Bimestre;
		LocalDate dataCadastro = LocalDate.now();
		System.out.println("I.D........:");
		id = scanner.nextLong();
		scanner.nextLine();
		if (id > 0) {
			NotaDao notaDao = new NotaDao(em);
			Nota nota = notaDao.buscarPorId(id);
			if (nota.getDataCadastro() != null) {
				String resp;
				System.out.println("Confirma a exclusao da ");
				resp = scanner.nextLine();
				if (resp == "S" || resp == "s") {
					em.getTransaction().begin();
					notaDao.remover(nota);
					em.getTransaction().commit();
					System.out.println("Nota Removido ");
				}
			}
		} else {
			System.out.println("Id Aluno..:");
			id_aluno = scanner.nextLong();
			AlunoDao alunoDao = new AlunoDao(em);
			Aluno aluno = alunoDao.buscarPorId(id_aluno);
			System.out.println(aluno.getNome());
			System.out.println("Id Serie..:");
			id_serie = scanner.nextLong();
			SerieDao serieDao = new SerieDao(em);
			Serie serie = serieDao.buscarPorId(id_serie);
			System.out.println(serie.getNome_Serie());
			System.out.println("Id Materia:");
			id_materia = scanner.nextLong();
			MateriaDao materiaDao = new MateriaDao(em);
			Materia materia = materiaDao.buscarPorId(id_materia);
			System.out.println(materia.getNome_Materia());
			System.out.println("1o Bimestre:");
			nota1Bimestre = scanner.nextFloat();
			System.out.println("2o Bimestre:");
			nota2Bimestre = scanner.nextFloat();
			System.out.println("3o Bimestre:");
			nota3Bimestre = scanner.nextFloat();
			System.out.println("4o Bimestre:");
			nota4Bimestre = scanner.nextFloat();
			//Nota nota = new Nota(nota1Bimestre, nota2Bimestre, nota3Bimestre, nota4Bimestre,
			//		dataCadastro);
			//nota.setPk(new NotaPK(id_aluno,id_serie,id_materia));
			Nota nota = new Nota(10.0F, 9.5F, 7.0F, 6.0F,LocalDate.now());
			nota.setPk(new NotaPK(2L, 1L, 1L));
			NotaDao notaDao = new NotaDao(em);

			em.getTransaction().begin();

			notaDao.cadastrar(nota);

			em.getTransaction().commit();

			System.out.println("Nota Gravado ");

		}
		em.close();
	}

	private static void consNotaPorAluno() {
		EntityManager em = JPAUtil.getEntityManager();
		Long id;
		System.out.println("I.D.Aluno:");
		id = scanner.nextLong();
		scanner.nextLine();
		NotaDao notaDao = new NotaDao(em);
		List <Nota> nota = notaDao.buscarPorAluno(id);
		//List <Nota> lista = new ArrayList<Nota>();
		System.out.println("Aluno:"+nota.get(0).getAluno().getNome());
		System.out.println();
		for (int i =0;i<=nota.size();i++) {
			System.out.println(nota.get(i).getSerie()+" "+nota.get(i).getMateria().getNome_Materia()+
					" "+ "1B:"+nota.get(i).getNota1Bimestre()+
					    " 2B:"+nota.get(i).getNota2Bimestre()+
					    " 3B:"+nota.get(i).getNota3Bimestre()+
					    " 4B:"+nota.get(i).getNota4Bimestre());
			//System.out.println(lista.get(i).getAluno().getNome());
	
		}
		em.close();
	}
	private static void consNotaPorSerie() {
		EntityManager em = JPAUtil.getEntityManager();
		Long id;
		System.out.println("I.D.Serie:");
		id = scanner.nextLong();
		scanner.nextLine();
		NotaDao notaDao = new NotaDao(em);
		List <Nota> nota = notaDao.buscarPorSerie(id);
		//List <Nota> lista = new ArrayList<Nota>();
		System.out.println("Serie:"+nota.get(0).getSerie().getNome_Serie());
		System.out.println();
		for (int i =0;i<=nota.size();i++) {
			System.out.println(nota.get(i).getAluno().getNome() +
					           nota.get(i).getMateria().getNome_Materia()+
					    " 1B:"+nota.get(i).getNota1Bimestre()+
					    " 2B:"+nota.get(i).getNota2Bimestre()+
					    " 3B:"+nota.get(i).getNota3Bimestre()+
					    " 4B:"+nota.get(i).getNota4Bimestre());
			//System.out.println(lista.get(i).getAluno().getNome());
	
		}
		em.close();
	}
}