<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMMAJORSETYPEEditViewBase from './pimmajorsetypeedit-view-base.vue';

import view_form from '@widgets/pim-major-setype/main-form/main-form.vue';

/**
 * 专业序列类型编辑视图
 *
 * @export
 * @class PIMMAJORSETYPEEditView
 * @extends {PIMMAJORSETYPEEditViewBase}
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
export default class PIMMAJORSETYPEEditView extends PIMMAJORSETYPEEditViewBase { }
</script>