let
  sources = import nix/sources.nix;
  nixpkgs = import sources.nixpkgs { };
in with nixpkgs;

mkShell {
  buildInputs = [
    maven
    jdk11
    postgresql_11
    # Tools to interact with our remote clusters
    google-cloud-sdk
    fluxctl
    kubectl
    kubectx
    niv # Tools to interact with Nix
  ]
  # Setup Nix-defined aliases
  ++(import nix/aliases.nix { }).aliases;

  CREDENTIALS_EXEMPLE = "0000-1111-2222";
}
