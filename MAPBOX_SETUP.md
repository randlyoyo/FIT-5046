# Mapbox Setup

This project reads the Mapbox access token from `local.properties`.

Add this line to your local `local.properties` file:

`MAPBOX_ACCESS_TOKEN=your_mapbox_public_token_here`

Build behavior:

- If `MAPBOX_ACCESS_TOKEN` exists in `local.properties`, Gradle generates the `mapbox_access_token` Android string resource from it.
- If the key is missing, Gradle uses the safe placeholder `MAPBOX_ACCESS_TOKEN_MISSING`.

Security rules:

- Every developer must keep their own public Mapbox token in `local.properties`.
- Never commit Mapbox public tokens (`pk.`) or secret tokens (`sk.`) to GitHub.
- The project owner can delete or revoke the dedicated token after the project ends.
