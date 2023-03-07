#!/bin/sh

cargo build --release --target aarch64-apple-darwin
cbindgen --config cbindgen.toml --crate color-flipper --output include/color_flipper.h

cp target/aarch64-apple-darwin/release/libcolor_flipper.a macOS/ColorFlipper/Frameworks/libcolor_flipper.a