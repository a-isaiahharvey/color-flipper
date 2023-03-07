//
//  ContentView.swift
//  ColorFlipper
//
//  Created by Allister Harvey on 3/5/23.
//

import SwiftUI

struct ContentView: View {
    @State var rgb = randomRgb()
    
    var body: some View {
        VStack {
            Canvas { context, size in
                context.fill(
                    Path(CGRect(origin: .zero, size: size)),
                    with: .color(Color(red: rgb.red, green: rgb.green, blue: rgb.blue)))
            }
            .frame(width: 300, height: 200)
            Button("Generate", action: {
                self.rgb = randomRgb()
            })
            
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
