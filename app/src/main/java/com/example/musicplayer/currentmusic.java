package com.example.musicplayer;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class currentmusic extends Fragment {

    public currentmusic() {
        // Required empty public constructor
    }

//    public interface callBack{
//        public void musicSelected();
//    }
//
//    private callBack listener;


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            listener = (callBack) context;
//        } catch (ClassCastException castException) {
//            /** The activity does not implement the listener. */
//            Log.i("info", "onAttach: the main activity does not implement the listener");
//        }
//    }

    String[] items;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_currentmusic, container, false);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new musiclist());
        fragmentTransaction.commit();

        return v;
    }

//    @Override
//    public void onActivityCreated(Bundle savedInstanceState)
//    {
//        Dexter.withContext(getActivity())
//                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
//                .withListener(new PermissionListener() {
//                    @Override
//                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
//
//                        final ListView myListViewForSongs  = (ListView)getActivity().findViewById(R.id.mySongListView);
//
//                        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());
//
//                        items = new String[mySongs.size()];
//
//                        for(int i = 0; i<mySongs.size();i++)
//                        {
//                            items[i] = mySongs.get(i).getName().toString().replace(".mp3","").replace(".wav","").replace(".m4a","");
//
//                        }
//
//                        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, items);
//                        myListViewForSongs.setAdapter(myAdapter);
//
//                        myListViewForSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                            @Override
//                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
////                                currentmusic firstFragment = new currentmusic();
////                                getFragmentManager().beginTransaction().add(R.id.frame_child_fragment, firstFragment).addToBackStack("first frag").commit();
//
//                                String songName = myListViewForSongs.getItemAtPosition(i).toString();
//
//                                 //works but doesnt really work lol
////                                FrameLayout fl = (FrameLayout) getActivity().findViewById(R.id.frame_child_fragment);
////                                fl.removeAllViews();
//
//                                musicplayer fragment = new musicplayer();
//                                Bundle args = new Bundle();
//                                args.putSerializable("songs", mySongs);
//                                args.putString("songname", songName);
//                                args.putInt("pos", i);
//                                fragment.setArguments(args);
//                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                                fragmentTransaction.replace(R.id.fragment_container, fragment);
//                                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                                fragmentTransaction.addToBackStack("MusicPlayer");
//                                fragmentTransaction.commit();
//
//
////                                startActivity(new Intent(getActivity(),musicplayer.class).putExtra("songs", mySongs).putExtra("songname",songName).putExtra("pos",i));
//                            }
//                        });
//
//
//                    }
//
//                    @Override
//                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
//                        Toast toast=Toast.makeText(getActivity(),"Sorry you dont have permission to access the songs",Toast.LENGTH_LONG);
//                        toast.show();
//                    }
//
//                    @Override
//                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
//                        permissionToken.continuePermissionRequest();
//                    }
//                }).check();
//        super.onActivityCreated(savedInstanceState);
//
//
//    }
//    public ArrayList<File> findSong(File file){
//
//        ArrayList<File> arrayList = new ArrayList<>();
//
//        File[] files = file.listFiles();
//        if(files != null){
//            for(File singleFile: files){
//                if(singleFile.isDirectory() && !singleFile.isHidden()){
//                    arrayList.addAll(findSong(singleFile));
//                }
//                else{
//                    if (singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav") || singleFile.getName().endsWith(".m4a")){
//                        arrayList.add(singleFile);
//                    }
//                }
//            }
//        }
//
//
//        return arrayList;
//
//    }




}
