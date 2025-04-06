package com.example.lutemon;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

// Notebook (To Do And Features)

// Lutémon Logo screen at the start
//

// LUTÉMONS:

//Ignivulp: (Fire type)
//  Ignivulp is a sleek, fox-like Lutémon with fur that glows softly like embers in the dark. Its tail flickers with fiery wisps, resembling a living flame that dances with every movement.
//  Its eyes burn with a golden hue, resembling molten fire, and its delicate paws seem to hover above the ground as it moves, as if it’s too light to touch the earth.
//  Its presence is often seen as a sign of hope, lighting the way forward with its radiant energy.

//Tux: (water/ice type)
//  Tux is a dignified, penguin-like Lutémon with a glossy, midnight-black body and icy blue accents that resemble frost creeping across its feathers.
//  when it dives into water, it leaves a trail of shimmering frost behind. Its sharp beak and talons are coated in ice, capable of freezing anything it touches.
//  Despite its graceful appearance, Tux exudes a playful energy, sliding effortlessly across icy surfaces and swimming with unmatched speed.
//  To many, it is a symbol of adaptability and grace, thriving in places where others cannot.

//Dorikit: (Magic Type)
//  Dorikit is a mischievous, orange-furred feline Lutémon with a shimmering, star-patterned coat that glows faintly in moonlight.
//  It wears a tiny, crooked wizard hat that pulses with magical energy. Its eyes sparkle like constellations, and its paws leave glowing imprints wherever it steps.
//  When casting spells, Dorikit’s hat emits a soft, radiant light, and arcane symbols appear briefly in the air around it. Known for its cleverness, it’s said to bring good fortune to trainers who earn its trust.

//Celestyne: (Air Type)
//  Celestyne is a breathtaking, otherworldly bird like Lutémon with an aura of pure elegance. Its translucent wings shimmer like wisps of clouds at dawn, catching the light in soft, iridescent hues of silver and pale blue.
//  The feathers seem to dissolve into mist at the edges, giving it the appearance of being part of the sky itself. Its slender body moves like wind currents, gliding effortlessly through the air effortlessly.
//  When it flies, faint trails of sparkling stardust swirl behind it, as though it carries the essence of the heavens. And its eyes glow softly, like moonlight breaking through a cloudy night

//Electryon: (Electric/Steel Type)
//  Electryon is a striking avian Lutémon with sleek, metallic feathers that gleam like polished steel. Its feathers are sharp and angular. and they hum with energy as it soars through the air.
//  Its eyes glow like piercing LED lights, cutting through even the darkest of nights. When it takes flight, it generates a faint magnetic field, causing small metallic objects nearby to tremble and rise.
//  it’s said to be the harbinger of storms, summoning lightning to the battlefield with every beat of its wings.