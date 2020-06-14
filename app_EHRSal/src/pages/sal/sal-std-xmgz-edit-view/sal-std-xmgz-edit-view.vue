<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdXmgzEditViewBase from './sal-std-xmgz-edit-view-base.vue';

import view_form from '@widgets/sal-std-xmgz/main-form/main-form.vue';

/**
 * 项目工资标准编辑视图
 *
 * @export
 * @class SalStdXmgzEditView
 * @extends {SalStdXmgzEditViewBase}
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
export default class SalStdXmgzEditView extends SalStdXmgzEditViewBase { }
</script>