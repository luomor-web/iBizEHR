<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdzyzgEditViewBase from './sal-stdzyzg-edit-view-base.vue';

import view_form from '@widgets/sal-stdzyzg/main-form/main-form.vue';

/**
 * 执业资格津贴标准编辑视图
 *
 * @export
 * @class SalStdzyzgEditView
 * @extends {SalStdzyzgEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class SalStdzyzgEditView extends SalStdzyzgEditViewBase { }
</script>