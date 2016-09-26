package com.movil.p.mathmagic;


        import android.content.Intent;
        import android.support.v4.view.PagerAdapter;
        import android.content.Context;
        import android.support.v4.view.PagerAdapter;
        import android.util.Log;
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

    private static final int REQUEST_CODE = 100;
    private String[] tematica_src= Juego.getTematica(1);
    private Context ctx;
    private LayoutInflater layoutInflater;
    Button button;
    TextView textView;
    TextView textTematic;

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
        textView = (TextView) item.findViewById(R.id.image_count);
        textTematic = (TextView) item.findViewById(R.id.tematica);
        button = (Button) item.findViewById(R.id.btn_sublvl);
        //imageView.setImageResource(image_src[position]);
        textView.setText("Lección "+(position+1));

        textTematic.setText(tematica_src[position]);
        container.addView(item);

        //Se habilita el boton segun el subnivel del jugador
        if(LogActivity.player.getSubNivel() > position) {
            button.setText("Empezar");
            button.setBackgroundColor(button.getContext().getResources().getColor(R.color.ColorAccent3));
        }else{
            button.setEnabled(false);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MainNivel","empecemos");
                Intent intent = new Intent(ctx,MainEjercicios.class);
                ctx.startActivity(intent);
            }
        });

        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
    
}