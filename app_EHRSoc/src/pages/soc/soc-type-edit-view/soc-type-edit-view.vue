<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SocTypeEditViewBase from './soc-type-edit-view-base.vue';

import view_form from '@widgets/soc-type/main-form/main-form.vue';

/**
 * 保险类型编辑视图
 *
 * @export
 * @class SocTypeEditView
 * @extends {SocTypeEditViewBase}
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
export default class SocTypeEditView extends SocTypeEditViewBase { }
</script>