/**
 * DDFPXX_C 部件模型
 *
 * @export
 * @class DDFPXX_CModel
 */
export default class DDFPXX_CModel {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof DDFPXX_CGridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof DDFPXX_CGridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'fplx',
          prop: 'fplx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'rzkssj',
          prop: 'rzkssj',
          dataType: 'DATE',
        },
        {
          name: 'pimpersonid',
          prop: 'pimpersonid',
          dataType: 'PICKUP',
        },
        {
          name: 'cfplx',
          prop: 'cfplx',
          dataType: 'SSCODELIST',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'fpzt',
          prop: 'fpzt',
          dataType: 'SSCODELIST',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pimdistirbutionid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pimdistirbutionid',
          dataType: 'GUID',
        },
        {
          name: 'srfmajortext',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormdutyname',
          prop: 'ormdutyname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgname',
          prop: 'ormorgname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgsectorname',
          prop: 'ormorgsectorname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'yzzid',
          prop: 'yzzid',
          dataType: 'PICKUP',
        },
        {
          name: 'rank',
          prop: 'rank',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'ormdutyid',
          prop: 'ormdutyid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostid1',
          prop: 'ormpostid1',
          dataType: 'PICKUP',
        },
        {
          name: 'ybmid',
          prop: 'ybmid',
          dataType: 'PICKUP',
        },
        {
          name: 'rzjssj',
          prop: 'rzjssj',
          dataType: 'DATE',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'pimdistirbution',
          prop: 'pimdistirbutionid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormorgsectorname_like',
        prop: 'n_ormorgsectorname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormpostname_like',
        prop: 'n_ormpostname_like',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'n_ormdutyname_like',
        prop: 'n_ormdutyname_like',
        dataType: 'PICKUPTEXT',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}