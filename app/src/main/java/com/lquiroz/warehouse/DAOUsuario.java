package com.lquiroz.warehouse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAOUsuario {
        Context c;
        Usuario u;
        ArrayList<Usuario> lista;
        SQLiteDatabase sql;
        String bd="BDUsuarios";
        String tabla = "create table if not exists  usuario(id integer primary key autoincrement," +
                        " usuario text,pass text,nombre text, apellido text, correo text, dni int, celular int, direccion text, codpostal int) ";
        public DAOUsuario(Context c ){
            this.c = c;
            sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE, null);
            sql.execSQL(tabla);
            u=new Usuario();
        }
        public boolean insertUsuario(Usuario u){
            if (buscar(u.getUsuario())==0) {
                ContentValues cv = new ContentValues();
                cv.put("usuario", u.getUsuario());
                cv.put("pass", u.getContraseña());
                cv.put("nombre", u.getNombre());
                cv.put("apellido", u.getApellidos());
                cv.put("correo", u.getCorreo());
                cv.put("dni", u.getDni());
                cv.put("celular", u.getCelular());
                cv.put("direccion", u.getDireccion());
                cv.put("codpostal", u.getCodPostal());
                return (sql.insert("usuario", null, cv) > 0);
            }else{
                return false;
            }
        }
        public int buscar(String u){
            int x=0;
            lista = selectUsuario();
            for (Usuario us:lista){
                   if (us.getUsuario().equals(u)){
                       x++;
                   }
            }
            return x;
        }
        public ArrayList<Usuario> selectUsuario(){
            ArrayList<Usuario> lista = new ArrayList<Usuario>();
            lista.clear();
            Cursor cr=sql.rawQuery("select*from usuario",null);
            if (cr!=null&&cr.moveToFirst()){
                do{
                    Usuario u=new Usuario();
                    u.setId(cr.getInt(0));
                    u.setUsuario(cr.getString(1));
                    u.setContraseña(cr.getString(2));
                    u.setNombre(cr.getString(3));
                    u.setApellidos(cr.getString(4));
                    u.setCorreo(cr.getString(5));
                    u.setDni(cr.getInt(6));
                    u.setCelular(cr.getInt(7));
                    u.setDireccion(cr.getString(8));
                    u.setCodPostal(cr.getInt(9));
                    lista.add(u);
                } while(cr.moveToNext());
            } return lista;
        }
        public int login(String u, String p) {
            int a = 0;
            Cursor cr = sql.rawQuery("select*from usuario", null);
            if (cr != null && cr.moveToFirst()) {
                do {
                     if (cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                         a++;
                     }
                } while (cr.moveToNext());
            }
            return a;
        }
        public Usuario getUsuario(String u, String p){
                  lista=selectUsuario();
                  for (Usuario us:lista){
                      if(us.getUsuario().equals(u)&&us.getContraseña().equals(p)){
                          return us;
                      }
                  }
                  return null;
        }
        public Usuario getUsuarioById(int id){
            lista=selectUsuario();
            for (Usuario us:lista){
                if(us.getId()==id){
                    return us;
                }
            }
            return null;
        }
}
