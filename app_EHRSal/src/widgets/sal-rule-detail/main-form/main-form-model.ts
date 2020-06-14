/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'salruledetailid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'salruledetailname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'salruleid',
        prop: 'salruleid',
        dataType: 'PICKUP',
      },
      {
        name: 'salparamname',
        prop: 'salparamname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'checkrule',
        prop: 'checkrule',
        dataType: 'SSCODELIST',
      },
      {
        name: 'salparamname2',
        prop: 'salparamname2',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'salruledetailid',
        prop: 'salruledetailid',
        dataType: 'GUID',
      },
      {
        name: 'salparamid2',
        prop: 'salparamid2',
        dataType: 'PICKUP',
      },
      {
        name: 'salparamid',
        prop: 'salparamid',
        dataType: 'PICKUP',
      },
      {
        name: 'salruledetail',
        prop: 'salruledetailid',
        dataType: 'FONTKEY',
      },
    ]
  }

}