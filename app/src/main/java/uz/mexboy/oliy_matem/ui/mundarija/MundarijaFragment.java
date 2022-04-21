package uz.mexboy.oliy_matem.ui.mundarija;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
;
import uz.mexboy.oliy_matem.MainActivity;
import uz.mexboy.oliy_matem.R;
import uz.mexboy.oliy_matem.adapter.MundarijaAdapter;
import uz.mexboy.oliy_matem.model.MundarijaModel;
import uz.mexboy.oliy_matem.ui.home.HomeFragment;

public class MundarijaFragment extends Fragment implements MundarijaAdapter.ItemClickListener {
    private Context mContext;
    private View root;
    private List<MundarijaModel> data;

    private RecyclerView recyclerView;

    private MundarijaAdapter mundarijaAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mundarija, container, false);

        init();
        return root;
    }

    private void init() {
        data = new ArrayList<>();
        data.add(new MundarijaModel("Bosh sahifa", 0));
        data.add(new MundarijaModel("So’z boshi", 2));
        data.add(new MundarijaModel("”Matematika” faniga kirish", 4));
        data.add(new MundarijaModel("To’plamlar va ular ustida amallar", 10));
        data.add(new MundarijaModel("Matritsalar", 22));
        data.add(new MundarijaModel("Determinantlar", 32));
        data.add(new MundarijaModel("Chiziqli tenglamalar sistemasi", 41));
        data.add(new MundarijaModel("Vektorlar. Vektorlar ustida chiziqli amallar", 50));
        data.add(new MundarijaModel("To’g’ri chiziq tenglamalari", 77));
        data.add(new MundarijaModel("Ikkinchi tartibli egri chiziqlar", 89));
        data.add(new MundarijaModel("Tekislik tenglamalari", 109));
        data.add(new MundarijaModel("Ikkinchi tartibli sirtlar", 124));
        data.add(new MundarijaModel("Funksiya tushunchasi", 137));
        data.add(new MundarijaModel("Funksiya limiti. Funksiyaning uzluksizligi", 150));
        data.add(new MundarijaModel("Funksiya hosilasi", 172));
        data.add(new MundarijaModel("Murakkab, oshkormas  va teskari funksiyalarning hosilasi", 186));
        data.add(new MundarijaModel("Funksiyaning differensiali", 197));
        data.add(new MundarijaModel("Aniqmas integral", 205));
        data.add(new MundarijaModel("Aniqmas integrallarni hisoblash usullari", 214));
        data.add(new MundarijaModel("Aniq integral", 222));
        data.add(new MundarijaModel("Nyuton-leybnits formulasi. Aniq integralda o‘zgaruvchini almashtirish va bo‘laklab integrallash", 230));
        data.add(new MundarijaModel("Aniq integralning geometriyaga tadbiqi", 237));
        data.add(new MundarijaModel("Tasodifiy hodisa", 256));
        data.add(new MundarijaModel("Ehtimollik tushunchasi", 263));
        data.add(new MundarijaModel("Nisbiy chastota. Nisbiy chastotaning turg‘unlik xususiyati", 269));
        data.add(new MundarijaModel("Birgalikda bo‘lmagan hodisalar yig‘indisining ehtimoli", 276));
        data.add(new MundarijaModel("Tajribalar ketma-ketligi. Bernulli formulasi", 285));
        data.add(new MundarijaModel("Glossariy", 292));
        data.add(new MundarijaModel("Foydalanilgan adabiyotlar", 299));


        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

        mundarijaAdapter = new MundarijaAdapter(mContext, data);
        mundarijaAdapter.setClickListener(this);
        recyclerView.setAdapter(mundarijaAdapter);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onItemClick(View view, int position) {
        MainActivity.defaultPage = data.get(position).getPage();

        MainActivity.toolbar.setTitle("Bosh sahifa");
        getActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.nav_host_fragment,
                        new HomeFragment())

                .commit();

        getActivity().getSupportFragmentManager().popBackStackImmediate();

        MainActivity.navPage = R.id.nav_home;


    }
}