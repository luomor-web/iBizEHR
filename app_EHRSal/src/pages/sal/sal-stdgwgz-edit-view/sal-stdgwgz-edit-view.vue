<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdgwgzEditViewBase from './sal-stdgwgz-edit-view-base.vue';

import view_form from '@widgets/sal-stdgwgz/main-form/main-form.vue';

/**
 * 岗位工资标准编辑视图
 *
 * @export
 * @class SalStdgwgzEditView
 * @extends {SalStdgwgzEditViewBase}
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
export default class SalStdgwgzEditView extends SalStdgwgzEditViewBase { }
</script>