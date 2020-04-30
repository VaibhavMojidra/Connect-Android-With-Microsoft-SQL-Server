package com.vaibhavmojidra.demo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DoItInBackground extends AsyncTask <Void,Void,Void>{
    Context c;
    String Res,name;
    ProgressDialog progressDialog;

    public DoItInBackground(Context context,String n) {
        c=context;
        name=n;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            Connection con=new ConnectionClass().CONN();
            Statement statement=con.createStatement();
            ResultSet rs=statement.executeQuery("Select * from Users where UserName='"+name+"'");
            if(rs.next()){
                Res="Username: "+name +" exists with ID: "+rs.getString(2);
            }
            else{
                Res="User not found with username: "+name;
            }
        }catch (Exception e){
            Res=e.getMessage();
        }
        return null;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(c);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        AlertDialog alertDialog = new AlertDialog.Builder(c).create();
        alertDialog.setTitle("Message");
        alertDialog.setMessage(Res);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}
