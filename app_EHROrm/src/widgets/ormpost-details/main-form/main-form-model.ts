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
        prop: 'ormpostdetailsid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormpostdetailsname',
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
        name: 'ormpostlibid',
        prop: 'ormpostlibid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormpostlibname',
        prop: 'ormpostlibname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormpostdetailsid',
        prop: 'ormpostdetailsid',
        dataType: 'GUID',
      },
      {
        name: 'ormpostdetails',
        prop: 'ormpostdetailsid',
        dataType: 'FONTKEY',
      },
    ]
  }

}