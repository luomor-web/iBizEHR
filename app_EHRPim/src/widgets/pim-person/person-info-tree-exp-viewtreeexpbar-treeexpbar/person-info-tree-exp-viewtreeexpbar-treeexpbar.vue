<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PersonInfoTreeExpViewtreeexpbarBase from './person-info-tree-exp-viewtreeexpbar-treeexpbar-base.vue';
import view_treeexpbar_tree from '@widgets/pim-person/personinfotree-treeview/personinfotree-treeview.vue';

 
@Component({
    components: {
        view_treeexpbar_tree, 
         
    }
})
export default class PersonInfoTreeExpViewtreeexpbar extends PersonInfoTreeExpViewtreeexpbarBase {

}
</script>