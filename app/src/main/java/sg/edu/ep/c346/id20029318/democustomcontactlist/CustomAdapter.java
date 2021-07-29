package sg.edu.ep.c346.id20029318.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;
    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects){

        super(context,resource,objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowV = inflater.inflate(layout_id,parent,false);

        TextView txtName = rowV.findViewById(R.id.txtName);
        TextView txtCode = rowV.findViewById(R.id.txtCountryCode);
        TextView txtNum = rowV.findViewById(R.id.txtPh);
        ImageView ivGender = rowV.findViewById(R.id.imgVGender);

        Contact currentItem = contactList.get(position);
        txtName.setText(currentItem.getName());
        txtCode.setText("+" + currentItem.getCountryCode());
        txtNum.setText(currentItem.getPhoneNum() + "");

        if (currentItem.getGender() == 'F') {
            ivGender.setImageResource(R.drawable.female);
        }
        else if (currentItem.getGender() == 'M') {
            ivGender.setImageResource(R.drawable.male);
        }


        return rowV;

    }

}
