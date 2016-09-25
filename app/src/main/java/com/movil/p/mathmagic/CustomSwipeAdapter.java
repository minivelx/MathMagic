package com.movil.p.mathmagic;


        import android.support.v4.view.PagerAdapter;
        import android.content.Context;
        import android.support.v4.view.PagerAdapter;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;

        import com.movil.p.mathmagic.R;

/**
 * Created by miguel on 24/09/16.
 */

public class CustomSwipeAdapter extends PagerAdapter {

    //private int[] image_src = {R.drawable.mario1,R.drawable.mario2,R.drawable.mario3 };
    private String[] tematica_src = {"Conoce los números", "Practica lo aprendido", "Suma"};
    private Context ctx;
    private LayoutInflater layoutInflater;

    public CustomSwipeAdapter(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return tematica_src.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item = layoutInflater.inflate(R.layout.viewerslides,container,false);
        //ImageView imageView = (ImageView) item.findViewById(R.id.image_view);
        TextView textView = (TextView) item.findViewById(R.id.image_count);
        TextView textTematic = (TextView) item.findViewById(R.id.tematica);
        Button button = (Button) item.findViewById(R.id.btn_sublvl);
        //imageView.setImageResource(image_src[position]);
        textView.setText("Lección "+(position+1));
        tematica_src = Juego.getTematica(1);
        textTematic.setText(tematica_src[position]);

        if(position==0)
            button.setText("Empezar");
        container.addView(item);
        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}