/**
 * YGSZKQ 部件模型
 *
 * @export
 * @class YGSZKQModel
 */
export default class YGSZKQModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof YGSZKQModel
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
        prop: 'wzd0001id',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'wzd0001name',
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
        name: 'profilelist',
        prop: 'profilelist',
        dataType: 'LONGTEXT',
      },
      {
        name: 'peoplenum',
        prop: 'peoplenum',
        dataType: 'INT',
      },
      {
        name: 'attendencesetup',
      },
      {
        name: 'wzd0001id',
        prop: 'wzd0001id',
        dataType: 'GUID',
      },
      {
        name: 'pcmwzd0001',
        prop: 'wzd0001id',
        dataType: 'FONTKEY',
      },
    ]
  }

}