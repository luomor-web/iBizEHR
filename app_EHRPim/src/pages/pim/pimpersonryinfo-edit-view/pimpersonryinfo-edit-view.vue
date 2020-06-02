<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPERSONRYInfoEditViewBase from './pimpersonryinfo-edit-view-base.vue';

import view_form from '@widgets/pim-person/main-form/main-form.vue';

/**
 * 人员信息编辑视图
 *
 * @export
 * @class PIMPERSONRYInfoEditView
 * @extends {PIMPERSONRYInfoEditViewBase}
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
export default class PIMPERSONRYInfoEditView extends PIMPERSONRYInfoEditViewBase { }
</script>