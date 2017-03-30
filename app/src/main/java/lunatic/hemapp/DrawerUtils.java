package lunatic.hemapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

/**
 * Created by -Lunatic on 29/03/2017.
 */

public class DrawerUtils {

    public static void makeDrawer(final Activity activity) {
        //Drawer
        SecondaryDrawerItem item1 = new SecondaryDrawerItem().withIdentifier(1).withName("");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.menu_Doadores);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName(R.string.menu_Top_Doadores);
        SecondaryDrawerItem item4 = new SecondaryDrawerItem().withIdentifier(4).withName(R.string.menu_Campanhas);
        SecondaryDrawerItem item5 = new SecondaryDrawerItem().withIdentifier(5).withName(R.string.menu_Doadores);

        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(activity)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem(),
                        item3,
                        new DividerDrawerItem(),
                        item4,
                        new DividerDrawerItem(),
                        item5,
                        new DividerDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){
                                                   @Override
                                                   public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                                       if (position == 2){
                                                           Snackbar.make(activity.findViewById(R.id.main_doacoes_recycler),"Paçoca",Snackbar.LENGTH_LONG).show();
                                                           Intent menuToDoadores = new Intent(activity, DoadoresActivity.class);
                                                           activity.startActivity(menuToDoadores);
                                                       }
                                                       return false;
                                                   }
                                               }
                );

        Toolbar toolbar = (Toolbar) activity.findViewById(R.id.toolbar);
        if(toolbar != null) {
            builder.withToolbar(toolbar);
        }
        builder.build();
    }
}
