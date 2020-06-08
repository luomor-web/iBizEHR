<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMGWTYPEEditViewBase from './pimgwtypeedit-view-base.vue';

import view_form from '@widgets/pim-gw-type/main-form/main-form.vue';

/**
 * 岗位类型对照表编辑视图
 *
 * @export
 * @class PIMGWTYPEEditView
 * @extends {PIMGWTYPEEditViewBase}
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
export default class PIMGWTYPEEditView extends PIMGWTYPEEditViewBase { }
</script>