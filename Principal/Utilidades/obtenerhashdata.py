import hashlib
import sys

hash_md5 = hashlib.md5()

with open(sys.argv[1], "rb") as f:
    for chunk in iter(lambda: f.read(4096), b""):
        hash_md5.update(chunk)


c_hash=hash_md5.hexdigest()

print c_hash
