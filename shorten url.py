import json
import os
import random
import string
from typing import Optional

_STORE_FILE = "store.json"
_CODE_LENGTH = 6
_ALPHABET = string.ascii_letters + string.digits  

def shorten(url: str) -> str:
    url = url.strip()
    if not url:
        raise ValueError("url cannot be empty")

    if os.path.exists(_STORE_FILE):
        try:
            with open(_STORE_FILE, "r", encoding="utf -8") as f:
                store = json.load(f)
        except Exception:
            store = {}
    else:
        store = {}
    for c, u in store.items():
        if u == url:
            return c

    def _gen_code() -> str:
        return "".join(random.choices(_ALPHABET, k=_CODE_LENGTH))

  
    max_attempts = 10000
    for _ in range(max_attempts):
        code = _gen_code()
        if code not in store:
            store[code] = url
            tmp = _STORE_FILE + ".tmp"
            with open(tmp, "w", encoding="utf-8") as f:
                json.dump(store, f, ensure_ascii=False, indent=2)
            os.replace(tmp, _STORE_FILE)
            return code

    raise RuntimeError(" Failed to generate ")


def redirect(code: str) -> Optional[str]:
    code = code.strip()
    if not code:
        return None
    if not os.path.exists(_STORE_FILE):
        return None
    try:
        with open(_STORE_FILE, "r", encoding="utf-8") as f:
            store = json.load(f)
    except Exception:
        return None

    return store.get(code)
