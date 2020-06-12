<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalPersonStdEditViewBase from './sal-person-std-edit-view-base.vue';

import view_form from '@widgets/sal-person-std/main-form/main-form.vue';

/**
 * 员工薪酬标准编辑视图
 *
 * @export
 * @class SalPersonStdEditView
 * @extends {SalPersonStdEditViewBase}
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
export default class SalPersonStdEditView extends SalPersonStdEditViewBase { }
</script>