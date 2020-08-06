package persistencia;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

import itens.Item;
import usuarios.Usuario;
import itens.Descritor;

public class serializeSistema implements Serializable{

	private static final long serialVersionUID = 1L;

		public static void salvarItens(Map<Integer, Item> itens) {
			try {

				FileOutputStream fos = new FileOutputStream("data/itens.dat");
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));

				oos.writeObject(itens);

				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		
		public static Map<Integer, Item> carregaItens() {
			try {

				File arquivo = new File("data/itens.dat");
				if (!arquivo.exists())
					arquivo.createNewFile();

				FileInputStream fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));

				@SuppressWarnings("unchecked")
				Map<Integer, Item> itens = (Map<Integer, Item>) ois.readObject();

				ois.close();
				return itens;

			} catch (IOException e) {
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			return null;

		}
		
		public static void salvarUsuarios(Map<String, Usuario> usuarios) {
			try {

				FileOutputStream fos = new FileOutputStream("data/usuarios.dat");
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));

				oos.writeObject(usuarios);

				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		
		public static Map<String, Usuario> carregaUsuarios() {
			try {

				File arquivo = new File("data/usuarios.dat");
				if (!arquivo.exists()) 
					arquivo.createNewFile();
				
				FileInputStream fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));

				@SuppressWarnings("unchecked")
				Map<String, Usuario> usuarios = (Map<String, Usuario>) ois.readObject();

				ois.close();
				return usuarios;

			} catch (IOException e) {
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			return null;

		}
		
		public static void salvarDescritores(Map<String, Descritor> descritores) {
			try {

				FileOutputStream fos = new FileOutputStream("data/descritores.dat");
				ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(fos));

				oos.writeObject(descritores);

				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		public static Map<String, Descritor> carregaDescritores() {
			try {

				File arquivo = new File("data/descritores.dat");
				if (!arquivo.exists()) 
					arquivo.createNewFile();
				
				FileInputStream fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(fis));

				@SuppressWarnings("unchecked")
				Map<String, Descritor> descritores = (Map<String, Descritor>) ois.readObject();

				ois.close();
				return descritores;

			} catch (IOException e) {
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			return null;

		}
	
}