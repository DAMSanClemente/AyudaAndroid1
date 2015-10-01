# AyudaAndroid1
AyudaAndroid1

Espero que os ayude un poco

Usarlo para consultar


Las barras de división entre los "bloques" del layout, mejor hacerlas con un view,
tal y como sale en los apuntes. que la forma que usé yo es bastante rebuscada.

    <LinearLayout
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:divider="@drawable/divider"
        android:showDividers="end">
        
en el layout:divider hay que meter un archivo que vamos a crear en la carpeta drawable: divider.xml

        <shape xmlns:android="http://schemas.android.com/apk/res/android">
             <size android:height="@dimen/divider_dim"/>
              <solid android:color="@color/negro"/>
        </shape>



Si queréis colaborar, crearos una cuenta de github y avisadme

Suerte
