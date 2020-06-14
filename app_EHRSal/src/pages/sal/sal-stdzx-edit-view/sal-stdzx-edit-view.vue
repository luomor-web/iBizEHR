<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdzxEditViewBase from './sal-stdzx-edit-view-base.vue';

import view_form from '@widgets/sal-stdzx/main-form/main-form.vue';

/**
 * 专项津贴标准编辑视图
 *
 * @export
 * @class SalStdzxEditView
 * @extends {SalStdzxEditViewBase}
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
export default class SalStdzxEditView extends SalStdzxEditViewBase { }
</script>