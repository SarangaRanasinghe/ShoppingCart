package com.example.shoppingcart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.shoppingcart.Model.common.shopItem;
import com.example.shoppingcart.Model.ui.ExpandShopGroup;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CreateAndFillValuesInListShoppingRows extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<ExpandShopGroup> groups;

    public CreateAndFillValuesInListShoppingRows(Context context, ArrayList<ExpandShopGroup> groups) {
        this.context = context;
        this.groups = groups;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        ArrayList<shopItem> chList=groups.get(groupPosition).getItems();
        return chList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        ArrayList<shopItem> chList=groups.get(groupPosition).getItems();
        return chList.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view, ViewGroup parent) {

        ExpandShopGroup group=(ExpandShopGroup)getGroup(groupPosition);
        if (view==null)
        {
            LayoutInflater inf=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inf.inflate(R.layout.expandlist_shopping_group,null);
        }
          /*  TextView tv = (TextView) view.findViewById(R.id.tvGroup);
            tv.setText(group.getName());

            TextView tvDate = (TextView) view.findViewById(R.id.tvGroupDate);
            tvDate.setText(group.getDate().split("T")[0]);

            View viewId = view.findViewById(R.id.deleteRow);
            if (viewId != null) {
                viewId.setTag(group.getShoppinID());
            }

            final TextView tvMenu = (TextView) view.findViewById(R.id.tvMenu);
            tvMenu.setTag(group.getShoppinID());

            tvMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showPickMenu(tvMenu);
                }
            });
            */


        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {

        shopItem child=(shopItem)getChild(groupPosition,childPosition);
        if (view==null)
        {
            LayoutInflater infaInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view=infaInflater.inflate(R.layout.expandlist_shopping_items,null);

        }

        TextView tv=(TextView)view.findViewById(R.id.tvChild1);
        tv.setText(child.getBrand().toString());

        TextView tv2=(TextView)view.findViewById(R.id.tvChild2);
        tv2.setText(child.getColor());

        TextView tv3=(TextView)view.findViewById(R.id.tvChild3);
        tv3.setText(String.valueOf(child.getSize()));

        TextView tv4=(TextView)view.findViewById(R.id.tvChild4);
        tv4.setText(child.getType());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public void showPickMenu(final View anchor)
    {
        final PopupMenu popupMenu=new PopupMenu(anchor.getContext(),anchor);
        popupMenu.inflate(R.menu.sale_item_option);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                View actionView=menuItem.getActionView();
                String shoppingId=(String)anchor.getTag();
                switch (menuItem.getItemId())
                {
                    case R.id.deleteRow:
                        FirebaseDatabase.getInstance().getReference("shopping")
                                .child(MainActivity.getSubscriberId(anchor.getContext())).child(shoppingId).removeValue();
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }

    public void addItem(shopItem item,ExpandShopGroup group)
    {
        if (!groups.contains((group)))
        {
            groups.add(group);
        }
        int index=groups.indexOf(group);
        ArrayList<shopItem> ch=groups.get(index).getItems();
        ch.add(item);
        groups.get(index).setItems(ch);
    }
}
