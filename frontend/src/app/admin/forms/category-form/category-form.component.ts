import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {

  // category: Category;
  categoryForm = new FormGroup({
    id: new FormControl(''),
    genre: new FormControl('', Validators.required)
  });

  catId: any;
  titleCreateCategory = "FORMÚLARIO PARA NOVO REGISTO";
  titleUpdateCategory = "ACTUALIZAR REGISTO"

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private categoryService: CategoryService
  ) {
    // this.category = new Category();
    this.getCategoryItem();
  }

  ngOnInit(): void {
  }

  getCategoryItem(){
    const catId = Number(this.route.snapshot.paramMap.get('id'));
    this.catId = catId;
    if (this.catId) {
      this.categoryService.findById(catId).subscribe(res => {
        this.categoryForm.patchValue({
          id: res.id,
          genre: res.genre
        })
      })
    }
  }

  categorySubmit() {
    if (this.categoryForm.valid) {
      this.categoryService.save(this.categoryForm.value).subscribe(result => {
        console.info(this.categoryForm.value);
        this.goToList();
        this.categoryForm.reset();

      });
    }
  }

  updateCategory() {
    if (this.categoryForm.valid) {
      this.categoryService.update(this.catId, this.categoryForm.value).subscribe(res => {
        this.goToList();
      })
    }
  }

  goToList() {
    this.router.navigate(['/admin/category/list']);
  }
}
