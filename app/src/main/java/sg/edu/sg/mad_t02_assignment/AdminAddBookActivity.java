package sg.edu.sg.mad_t02_assignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class AdminAddBookActivity extends AppCompatActivity {

    private String TAG = "Learning@NP";
    private String FILENAME = "AdminAddBookActivity.java";

    private String BkName;
    private String BkPrice;
    private String BkDescription;

    private ImageView NewBookImage;
    private EditText NewBookName;
    private EditText NewBookPrice;
    private EditText NewBookDescription;
    private Button AddNewBookButton;

    private Uri ImageUri;
    private static final int GalleryPick = 1;
    private StorageReference BookImageRef;
    private DatabaseReference dbRef;
    NewBookModel book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_book);

        book = new NewBookModel();

        NewBookImage = findViewById(R.id.select_book_image);
        NewBookName = findViewById(R.id.new_book_name);
        NewBookPrice = findViewById(R.id.new_book_price);
        NewBookDescription = findViewById(R.id.new_book_description);
        AddNewBookButton = findViewById(R.id.add_new_book);

        BookImageRef = FirebaseStorage.getInstance().getReference("Images");
        dbRef = FirebaseDatabase.getInstance().getReference("Books");

        Log.v(TAG, "Finished Pre-Initialization");

        NewBookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenGallery();
            }
        });

        AddNewBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BkName = NewBookName.getText().toString();
                BkPrice = NewBookPrice.getText().toString();
                BkDescription = NewBookDescription.getText().toString();

                if (ImageUri == null)
                {
                    Toast.makeText(AdminAddBookActivity.this,"Please select an image", Toast.LENGTH_SHORT).show();
                }

                else if (TextUtils.isEmpty(BkName))
                {
                    NewBookName.requestFocus();
                    NewBookName.setError("FIELD CANNOT BE EMPTY");
                }
                else if(TextUtils.isEmpty(BkPrice))
                {
                    NewBookPrice.requestFocus();
                    NewBookPrice.setError("FIELD CANNOT BE EMPTY");
                }
                else if(!BkPrice.matches("^(\\d+(?:,\\d{1,2})?).*"))
                {
                    NewBookPrice.requestFocus();
                    NewBookPrice.setError("ENTER ONLY NUMERIC CHARACTERS");
                }

                else if (TextUtils.isEmpty(BkDescription))
                {
                    NewBookDescription.requestFocus();
                    NewBookDescription.setError("FIELD CANNOT BE EMPTY");
                }
                else {
                    FileUpload();
                }
            }
        });
    }

    private String getExtension(Uri uri)
    {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    //uploads image into firebase storage
    private void FileUpload()
    {
        final Float bkPrice = Float.parseFloat(NewBookPrice.getText().toString().trim());

        final StorageReference sRef = BookImageRef.child((System.currentTimeMillis() + "." + getExtension(ImageUri)));

        sRef.putFile(ImageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        // Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        sRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                Uri downloadUrl = uri;
                                //Do what you want with the url
                                Toast.makeText(AdminAddBookActivity.this, "Image successfully uploaded.", Toast.LENGTH_LONG).show();

                                book.setNBookName(NewBookName.getText().toString().trim());
                                book.setNBookPrice(bkPrice);
                                book.setNBookDescription(NewBookDescription.getText().toString().trim());
                                book.setNBookImage(downloadUrl.toString());

                                String uploadId = dbRef.push().getKey();
                                dbRef.child(uploadId).setValue(book);
                                Toast.makeText(AdminAddBookActivity.this, "Book successfully added.", Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                        Toast.makeText(AdminAddBookActivity.this,"Image upload failed.", Toast.LENGTH_LONG).show();
                    }
                });
    }

    //method to open up device file manager
    private void OpenGallery()
    {
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(galleryIntent,GalleryPick);
    }

    //get the image to fill in imageview
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GalleryPick && resultCode == RESULT_OK && data != null)
        {
            ImageUri = data.getData();
            Picasso.get().load(ImageUri).into(NewBookImage);
        }
    }

}