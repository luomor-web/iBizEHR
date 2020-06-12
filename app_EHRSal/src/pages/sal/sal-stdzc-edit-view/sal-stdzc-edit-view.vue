<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdzcEditViewBase from './sal-stdzc-edit-view-base.vue';

import view_form from '@widgets/sal-stdzc/main-form/main-form.vue';

/**
 * 职称类别标准编辑视图
 *
 * @export
 * @class SalStdzcEditView
 * @extends {SalStdzcEditViewBase}
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
export default class SalStdzcEditView extends SalStdzcEditViewBase { }
</script>