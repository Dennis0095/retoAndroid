package com.comercio.retoandroid.ui.feature.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.comercio.core.model.Address
import com.comercio.core.model.Company
import com.comercio.core.model.Geolocation
import com.comercio.core.model.User
import com.comercio.retoandroid.R
import com.comercio.retoandroid.databinding.ActivityUsersBinding
import com.comercio.retoandroid.ui.feature.user.adapter.AdapterUser
import com.comercio.retoandroid.ui.util.UtilRecyclerView

class UsersActivity : AppCompatActivity() {
    lateinit var binding: ActivityUsersBinding
    lateinit var adapterUser: AdapterUser
    private var listUser = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        UtilRecyclerView.config(binding.rvUsers, true, this)
        UtilRecyclerView.config(binding.rvPosts, false, this)
        setAdapterUser()
    }


    private fun setAdapterUser() {
        listUser.add(User(id = 1, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 2, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 3, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 4, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 5, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 6, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 7, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))
        listUser.add(User(id = 8, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))
        listUser.add(User(id = 9, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 10, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))

        listUser.add(User(id = 11, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))
        listUser.add(User(id = 12, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))
        listUser.add(User(id = 13, name = "Dennis", userName = "dmendez", email = "dnrich95@gmail.com",
            address = Address(street = "Kulas Light", suite = "Apt. 556", city = "Gwenborough", zipcode = "92998-3874",
            geo = Geolocation(lat = "-37.3159", lng = "81.1496")), phone = "770-736-8031", website = "hildegard.org", company = Company(name = "Romaguera-Crona", catchPhrase = "Multi-layered client-server neural-net",
            bs = "")
        ))


        adapterUser = AdapterUser(listUser)
        binding.rvUsers.adapter = adapterUser
    }
}