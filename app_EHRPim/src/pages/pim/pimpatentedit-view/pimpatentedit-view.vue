<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPATENTEditViewBase from './pimpatentedit-view-base.vue';

import view_form from '@widgets/pim-patent/main-form/main-form.vue';

/**
 * 专利信息编辑视图
 *
 * @export
 * @class PIMPATENTEditView
 * @extends {PIMPATENTEditViewBase}
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
export default class PIMPATENTEditView extends PIMPATENTEditViewBase { }
</script>