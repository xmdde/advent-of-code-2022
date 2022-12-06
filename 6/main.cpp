#include <iostream>
#include <fstream>
using namespace std;

int part_one(const string data, const int l);
int part_two(const string data, const int l);
bool no_duplicates(char* arr);

int main() {
    ifstream file("/Users/justynaziemichod/Documents/advent-of-code-2022/6/data.txt");
    string data;
    file >> data;
    cout << part_one(data, data.length()) << '\n';
    cout << part_two(data, data.length());
    return 0;
}

int part_one(const string data, const int l) {
    for (int i = 3; i < l; i++) {
        if (data[i] != data[i-1] && data[i] != data[i-2] && data[i] != data[i-3]) {
            if (data[i-1] != data[i-2] && data[i-1] != data[i-3] && data[i-2] != data[i-3])
                return i+1;
        }
    }
    return -1;
}

int part_two(const string data, const int l) {
    for (int i = 13; i < l; i++) {
        char arr[14];
        int pos = 0;
        for (int j = i-13; j <= i; j++) {
            arr[pos] = data[j];
            pos++;
        }
        sort(arr, arr + 14);
        if (no_duplicates(arr))
            return i+1;
    }
    return -1;
}

bool no_duplicates(char* arr) {
    for (int j = 1; j < 14; j++) {
        if (arr[j] == arr[j-1])
            return false;
    }
    return true;
}